import com.sun.xml.internal.ws.client.sei.MethodHandler;

import javax.print.DocFlavor;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;

public class TotalCalculator {
    int TOTAL = 3;

    public long getTOTAL(short value) {
        return TOTAL + value;
    }
}
//
//class ReflectionTest{
//    public static void explore(Object object){
//        Class<?> clazz = object.getClass();
//        System.out.println("clazz name" + clazz.getName());
//        try {
//            Field field = clazz.getDeclaredField("TOTAL");
//            Method method = clazz.getDeclaredMethod("getTOTAL", new Class[]{int.class});
//            field.setAccessible(true);
//            Field modifierField = Field.class.getDeclaredField("modifiers");
//            modifierField.setAccessible(true);
//            modifierField.setInt(field, field.getModifiers()&~Modifier.FINAL);
//            field.set(object, 25);
//            System.out.println("method return value = " + method.invoke(object, new Object[]{5}));
//            System.out.println("total values is 2 " + field.getInt(object));
//            System.out.println("total value is "  + field.get(object));
//        } catch (NoSuchFieldException e) {
//            System.out.println(e.getMessage());
//        } catch (IllegalAccessException e) {
//            System.out.println(e.getMessage());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        try {
//            Object object =TotalCalculator.class.newInstance();
//            explore(object);
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//}

class MethodHandlerExample {
    public static void main(String[] args) {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {

            MethodHandle mh = lookup.findVirtual(TotalCalculator.class, "getTOTAL",
                    MethodType.methodType(long.class, short.class));
            Object object = TotalCalculator.class.newInstance();
            Class<?> clazz = object.getClass();
            System.out.println(mh.invoke(object, (short) 23));
            MethodHandle mh2 = lookup.findStatic(clazz, "caculate", MethodType.methodType(String.class));
            System.out.println(mh2.invokeExact());



            Object object1 = TotalCalculator.class.newInstance();
            clazz = object1.getClass();
            mh = lookup.findSetter(clazz, "TOTAL", int.class);
            mh.invoke(object1, 15);
            mh = lookup.findVirtual(clazz, "getTOTAL", MethodType.methodType(long.class, short.class));
            System.out.println(mh.invoke(object1, (short)23));


            mh = lookup.findVirtual(clazz, "getTOTAL", MethodType.methodType(long.class, short.class));
            System.out.println(mh.invoke(object,(short)23));
            mh = MethodHandles.insertArguments(mh, 1, (short)10);
            System.out.printf("total = %d", mh.invoke(object));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
