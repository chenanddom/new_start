package chapter19;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassLoaderTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method method : declaredMethods) {
                //获取方法修饰符
                String methodModifier = Modifier.toString(method.getModifiers());
                System.out.print(methodModifier+" ");
                //获取方法返回值
                String methodName = method.getReturnType().getSimpleName();
                System.out.print(methodName+"(");
                //获取方法参数列表
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes==null || parameterTypes.length==0){
                    System.out.print(")");
                }
                for (int i = 0; i < parameterTypes.length; i++) {
                    char end = i==parameterTypes.length-1?')':',';
                    System.out.print(parameterTypes[i].getSimpleName()+end);
                }
                System.out.println();


            }     

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
