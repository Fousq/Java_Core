package kz.zhanbolat.chief.util;

import java.io.IOException;

public interface ReflectionScanner {
    Class<?>[] getClasses(String packageName) throws IOException;
}
