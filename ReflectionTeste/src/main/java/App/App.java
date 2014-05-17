package App;

/**
 * Hello world!
 *
 */
import java.lang.reflect.*;

public class App{
        
    public int funcao1(Object p, int x) throws NullPointerException {
        if (p == null) {
            throw new NullPointerException();
        }
        return x;
    }

    public static void main(String args[]) throws Exception, ClassNotFoundException{
        
        try {
            
            Class cls = Class.forName("App.App");
            Method methlist[] = cls.getDeclaredMethods();
            
            for (Method m : methlist){
                System.out.println("nome = " + m.getName());
                System.out.println("membro da classe = " + m.getDeclaringClass());
                System.out.println("modificador = " + Modifier.toString(m.getModifiers()));
                Class pvec[] = m.getParameterTypes();
                 
                for (int j = 0; j < pvec.length; j++) {
                    System.out.println("parâmetro #" + j + " " + pvec[j]);
                }

                Class evec[] = m.getExceptionTypes();
                for (int j = 0; j < evec.length; j++) {
                    System.out.println("exceção #" + j + " " + evec[j]);
                }

                System.out.println("tipo de retorno = " + m.getReturnType());
                System.out.println("-----");
            }
        } catch (Throwable e) {
            System.out.println("Epa epa epa");
            System.err.println(e);
        }
    }
}
