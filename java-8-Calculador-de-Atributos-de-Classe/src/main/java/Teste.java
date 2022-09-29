import com.challenge.annotation.Somar;

import java.math.BigDecimal;

public class Teste {

    @Somar
    private BigDecimal num1;

    @Somar
    private BigDecimal num2;

    public Teste(BigDecimal num1, BigDecimal num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}
