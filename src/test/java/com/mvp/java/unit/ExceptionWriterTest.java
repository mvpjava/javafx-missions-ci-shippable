package com.mvp.java.unit;

import com.mvp.java.logging.ExceptionWriter;
import java.io.Writer;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class ExceptionWriterTest {

    Writer writer;//mock
    ExceptionWriter exceptionWriter;//SUT

    @Before
    public void before() {
        writer = Mockito.mock(Writer.class);
        exceptionWriter = new ExceptionWriter(writer);
    }

    @Test
    public void checkConvertionOfStackTraceToString() {
        StackTraceElement[] stackTrace = new StackTraceElement[1];
        stackTrace[0] = new StackTraceElement("at com.mvp.java.controllers.ConsoleTabController", "onMouseClicked", "ConsoleTabController.java", 46);
        Throwable throwable = new Throwable();
        throwable.setStackTrace(stackTrace);

        String stackTraceAsString = "com.mvp.java.controllers.ConsoleTabController.onMouseClicked(ConsoleTabController.java:46)";
        when(writer.toString()).thenReturn(stackTraceAsString);
        assertEquals(stackTraceAsString, exceptionWriter.getExceptionAsString(throwable).trim());
    }
}
