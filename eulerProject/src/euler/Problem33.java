package euler;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import euler.utils.DigitUtil;


/**
 * 16/64=1/4
 * 19/95=1/5
 * 26/65=2/5
 * 49/98=4/8
 * 
 * 387296/38729600 = 1/100
 */
public class Problem33 {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					String sn1 = String.valueOf(i) + String.valueOf(k);
					String sn2 = String.valueOf(k) + String.valueOf(i);
					int n1 =Integer.valueOf(sn1);
					int n2 =Integer.valueOf(sn2);
					String sd1 = String.valueOf(j) + String.valueOf(k);
					String sd2 = String.valueOf(k) + String.valueOf(j);
					int d1 =Integer.valueOf(sd1);
					int d2 =Integer.valueOf(sd2);
					BigDecimal db11 = new BigDecimal((float)n1 / d1);
					BigDecimal db21 = new BigDecimal((float)n2 / d1);
					BigDecimal db12 = new BigDecimal((float)n1 / d2);
					BigDecimal db22 = new BigDecimal((float)n2 / d2);
					BigDecimal db = new BigDecimal((float)i / j);
					if (db.intValue() < 1) {
						if (db.equals(db11)) {
							System.out.println(n1 + "/" + d1 + "=" + i + "/" + j);
						}
						if (db.equals(db12)) {
							System.out.println(n1 + "/" + d2 + "=" + i + "/" + j);
						}
						if (db.equals(db21)) {
							System.out.println(n2 + "/" + d1 + "=" + i + "/" + j);
						}
						if (db.equals(db22)) {
							System.out.println(n2 + "/" + d2 + "=" + i + "/" + j);
						}
					}
				} 
			}
		}
	}

}
