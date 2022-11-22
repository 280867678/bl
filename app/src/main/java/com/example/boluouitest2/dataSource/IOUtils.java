package com.example.boluouitest2.dataSource;



import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

public class IOUtils {

    public static void copy(InputStream inputStream, Writer writer, String str) throws IOException {
        if (str == null) {
            copy(inputStream, writer);
        } else {
            copy(new InputStreamReader(inputStream, str), writer);
        }
    }

    public static void copy(InputStream inputStream, Writer writer) throws IOException {
        copy(new InputStreamReader(inputStream), writer);
    }


    public static int copy(Reader reader, Writer writer) throws IOException {
        long copyLarge = copyLarge(reader, writer);
        if (copyLarge > 2147483647L) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static long copyLarge(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[4096];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += (long) read;
        }
    }


}

