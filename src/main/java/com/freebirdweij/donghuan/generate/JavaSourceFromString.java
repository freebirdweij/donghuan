package com.freebirdweij.donghuan.generate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.tools.JavaFileObject;

public class JavaSourceFromString implements JavaFileObject {

    public JavaSourceFromString(String className, String sourceCode) {
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CharSequence getCharContent(boolean arg0) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCharContent'");
    }

    @Override
    public long getLastModified() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLastModified'");
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public InputStream openInputStream() throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'openInputStream'");
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'openOutputStream'");
    }

    @Override
    public Reader openReader(boolean arg0) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'openReader'");
    }

    @Override
    public Writer openWriter() throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'openWriter'");
    }

    @Override
    public URI toUri() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toUri'");
    }

    @Override
    public Modifier getAccessLevel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccessLevel'");
    }

    @Override
    public Kind getKind() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getKind'");
    }

    @Override
    public NestingKind getNestingKind() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNestingKind'");
    }

    @Override
    public boolean isNameCompatible(String arg0, Kind arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isNameCompatible'");
    }

}
