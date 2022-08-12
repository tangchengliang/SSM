import com.tcl.spring.proxy.Calculator;
import com.tcl.spring.proxy.CalculatorImpl;
import com.tcl.spring.proxy.CalculatorStaticProxy;
import com.tcl.spring.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTest {
    @Test
    public void testProxy(){
        CalculatorStaticProxy  proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1,2);
    }

    @Test
    public void testDynamicProxy(){
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.div(1,0);

    }
}
