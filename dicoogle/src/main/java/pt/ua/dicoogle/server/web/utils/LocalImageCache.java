/**
 * Copyright (C) 2014  Universidade de Aveiro, DETI/IEETA, Bioinformatics Group - http://bioinformatics.ua.pt/
 *
 * This file is part of Dicoogle/dicoogle.
 *
 * Dicoogle/dicoogle is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Dicoogle/dicoogle is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Dicoogle.  If not, see <http://www.gnu.org/licenses/>.
 */
package pt.ua.dicoogle.server.web.utils;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Handles the caching of PNG images generated by the (DIC2PNG) Image Servlet.
 * The cached images are kept inside a temporary directory created inside the user (or system) temporary directory.
 * These are maintained for a maximum period of time if they are not used, and deleted on a regular basis to save disk space while not hurting the cache performance.
 *
 * @author António Novo <antonio.novo@ua.pt>
 */
public class LocalImageCache extends Thread
{
	/**
	 * The name of the cache directory.
	 */
	private String name;
	/**
	 * The number of mili-seconds to wait between pool cache directory pooling.
	 */
	private int interval;
	/**
	 * The number of mili-seconds that a file can stay in the cache without being used/read.
	 */
	private int maxAge;

	private File cacheFolder;
	private boolean running;

	private LinkedList<File> filesBeingWritten;

	/**
	 * Creates a local image cache that pools its cache directory at interval rates and deletes files older than maxAge.
	 *
	 * @param name the name of the cache directory.
	 * @param interval the number of seconds to wait between pool cache directory pooling.
	 * @param maxAge the number of seconds that a file can stay in the cache without being used/read.
	 */
	public LocalImageCache(String name, int interval, int maxAge)
	{
		this.name = name;

		if (interval < 1)
		{
			this.interval = 1;
		}
		else
		{
			this.interval = interval;
		}
		this.interval *= 1000;

		if (maxAge < 1)
		{
			this.maxAge = 1;
		}
		else
		{
			this.maxAge = maxAge;
		}
		this.maxAge *= 1000;

		filesBeingWritten = new LinkedList<File>();
		running = false;
	}

	/**
	 * Deletes a directory and all its contents.
	 *
	 * @param dir the directory to delete.
	 */
	private static void deleteDirectory(File dir)
	{
		if ((dir == null) || (! dir.exists()))
		{
			return;
		}

		// delete all the files and folders inside this folder
		for (File f : dir.listFiles())
		{
			if (f.isDirectory())
			{
				// if it's a sub-directory then delete its content
				deleteDirectory(f);
			}
			else
			{
				f.delete();
			}
		}

		// remove the folder
		dir.delete();
	}

	@Override
	public void start()
	{
		// create the temporary directory
		File sysTmpDir = new File(System.getProperty("java.io.tmpdir"));
		cacheFolder = new File(sysTmpDir, name);

		// abort if we couldn't make the temp dir
		if (cacheFolder == null)
			return;
		if (! cacheFolder.exists())
			if (! cacheFolder.mkdir())
				return;
		cacheFolder.deleteOnExit();

		// start running
		super.start();
	}

	@Override
	public void run()
	{
		// if the cache isn't setup abort
		if (! cacheFolder.exists())
			return;

		running = true;
		do
		{
			// check if there are any files worh deleting and if so do it
			checkAndRemoveOldFiles();

			// wait for the defined interval to be over
			try
			{
				Thread.sleep(interval);
			}
			catch (InterruptedException ex)
			{
				// do nothing
			}
		}
		while (isRunning());
	}

	/**
	 * Stop this cache from checking for old files.
	 */
	public synchronized void terminate()
	{
		this.running = false;

		// if needed wake the thread from its sleeping state
		this.interrupt();

		// clear and delete the temporary folder
		deleteDirectory(cacheFolder);
	}

	/**
	 * Loops through the cache folder and tries to removes old/un-used files.
	 */
	private void checkAndRemoveOldFiles()
	{
		// if the cache isn't setup abort
		if (! cacheFolder.exists())
			return;

		long currentTime = System.currentTimeMillis();

		// go through all the files inside the temp folder and check their last access
		for (File f : cacheFolder.listFiles())
		{
			// skip if the current file is a folder
			if (f.isDirectory())
				continue;

			// check the last access done to the file, and if it's "past its due" tries to delete it
			if (currentTime - f.lastModified() > maxAge)
				f.delete();
		}
	}

	/**
	 * @return the interval
	 */
	public int getInterval()
	{
		return interval;
	}

	/**
	 * @param interval the interval to set
	 */
	public void setInterval(int interval)
	{
		if (interval < 1)
		{
			this.interval = 1;
		}
		else
		{
			this.interval = interval;
		}
		this.interval *= 1000;
	}

	/**
	 * @return the maxAge
	 */
	public int getMaxAge()
	{
		return maxAge;
	}

	/**
	 * @param maxAge the maxAge to set
	 */
	public void setMaxAge(int maxAge)
	{
		if (maxAge < 1)
		{
			this.maxAge = 1;
		}
		else
		{
			this.maxAge = maxAge;
		}
	}

	public synchronized File getFileFromName(String fileName)
	{
		// check if the file is currently being written to
		for (File f : filesBeingWritten)
		{
			// and if it is, return a common handle for it (common so outside code can synchronize on it, same object, to allow other threads to wait for the write to finish)
			if (f.getName().equalsIgnoreCase(fileName))
				return f;
		}

		String absoluteFileName = cacheFolder + File.separator + fileName;
		File f = new File(absoluteFileName);

		// if the file already exists return a handle to it
		if (f.exists())
			return f;

		// if it does not exist add it to the list of files being written (because new content is going to be written to it outside this class) and create the empty file
		filesBeingWritten.add(f);
		try
		{
			f.createNewFile();
			f.deleteOnExit();
		}
		catch (IOException ex)
		{
			return null; // abort
		}

		// return the common handle to the currently created and empty file
		return f;
	}

	/**
	 * To be used by a thread that has finished writting or reading to the file.
	 *
	 * @param file the same file handler (object) that was obtained by calling this.getFileFromName().
	 */
	public synchronized void finishedUsingFile(File file)
	{
		if ((file == null))
			return;

		// tries to remove the file from the list of file being written to
		filesBeingWritten.remove(file);

		// touch the file so that we can keep track of how old the file is
		if (file.exists())
			file.setLastModified(System.currentTimeMillis());
	}

	/**
	 * @return if the caching mechanism for checking and removing old/un-used cache files is still running
	 */
	public boolean isRunning()
	{
		return running;
	}
}
