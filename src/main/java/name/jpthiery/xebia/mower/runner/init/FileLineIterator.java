package name.jpthiery.xebia.mower.runner.init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileLineIterator implements Iterator<String>{

	private String fileName;
	
	private final BufferedReader reader;
	
	private String nextLine;
	
	public FileLineIterator(String fileName) {
		if (fileName == null) {
			throw new IllegalArgumentException("fileName can't be null.");
		}
		this.fileName = fileName;
		File file = new File(fileName);
		if (!file.canRead()) {
			throw new IllegalStateException(String.format("Can't read file %s.", file.getAbsolutePath()));
		}
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			throw new IllegalStateException(String.format("Unable to read file %s.", file.getAbsolutePath()), e);
		}
		readNextLine();// Read first line to be able to say if with had at least one line to read.
		
	}
	
	@Override
	public boolean hasNext() {
		boolean res = nextLine != null;
		if (!res) {
			//	We are a the end of file, close the reader.
			try {
				reader.close();
			} catch (IOException e) {
				throw new IllegalStateException(String.format("Unable to close the reader for file %s.", fileName), e);
			}
		}
		return res;
	}

	@Override
	public String next() {
		String res = nextLine;
		readNextLine();
		return res;
	}

	private void readNextLine() {
		try {
			nextLine = reader.readLine();
		} catch (IOException e) {
			throw new IllegalStateException("Unable to read next line due to the following error.", e);
		}
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Can't remove line from files with this iterator.");		
	}

}
