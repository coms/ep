package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

import euler.poker.PokerHand;
import euler.utils.AlphabetHelper;
import euler.utils.DigitUtil;
import euler.utils.Fraction;
import euler.utils.MathHelper;
import euler.utils.PowHelper;
import euler.utils.Prime;

/**
* Problem 57
* sqrt(2) ?
 **/
public class Problem57 {

	public static void main(String[] args) {
		long num = 3;
		long denum = 2;
		Fraction f = new Fraction(3,2);
		System.out.println(f);
		long nextDenum = 1*denum + num;
		long nextNum = 1*denum + num;
	}
	
}
