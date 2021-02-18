package com.cabanaban.entity;

import com.cabanaban.entity.exceptions.InvalidNationaIDContentException;
import com.cabanaban.entity.exceptions.InvalidNationalIDCheckDigitException;
import com.cabanaban.entity.exceptions.InvalidNationalIDLengthException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NationalID {

    private static int CPF_LENGTH = 11;
    private static int CPF_NUMBER_LENGTH = 9;
    private static int CHECK_DIGIT_START_INDEX = 9;
    private static int CPF_DIGIT_LENGTH = 2;
    private static int CPF_MOD = 11;

    private final String nationalID;

    public NationalID(String nationalID) throws InvalidNationalIDLengthException, InvalidNationaIDContentException, InvalidNationalIDCheckDigitException {
        this.nationalID = nationalID;
        checkLength()
                .checkOnlyNumbers()
                .checkDigit();
    }

    private NationalID checkLength() throws InvalidNationalIDLengthException {
        if (nationalID.length() != CPF_LENGTH) {
            throw new InvalidNationalIDLengthException(nationalID);
        }
        return this;
    }

    private NationalID checkOnlyNumbers() throws InvalidNationaIDContentException {
        Pattern pattern = Pattern.compile("^[0-9]{" + CPF_LENGTH + "}$");
        Matcher matcher = pattern.matcher(nationalID);
        if (!matcher.matches()) {
            throw new InvalidNationaIDContentException(nationalID);
        }
        return this;
    }

    private NationalID checkDigit() throws InvalidNationalIDCheckDigitException {
        String cpfDigitPart = nationalID.substring(0, CPF_NUMBER_LENGTH);
        int firstCheckDigit = calculateFirstCheckDigit(cpfDigitPart);
        int secondCheckDigit = calculateSecondCheckDigit(cpfDigitPart, Integer.toString(firstCheckDigit));
        String informedCheckDigit = nationalID.substring(CHECK_DIGIT_START_INDEX);
        String calculatedCheckDigit = firstCheckDigit + Integer.toString(secondCheckDigit);
        if (!calculatedCheckDigit.equals(informedCheckDigit)) {
            throw new InvalidNationalIDCheckDigitException(nationalID);
        }
        return this;
    }

    private int calculateFirstCheckDigit(String cpfDigitPart) {
        int firstDigitSum = calculateSum(cpfDigitPart);
        return calculateMod11(firstDigitSum);
    }

    private int calculateSecondCheckDigit(String cpfDigitPart, String firstCheckDigit) {
        String cpfPart = cpfDigitPart + firstCheckDigit;
        int secondDigitSum = calculateSum(cpfPart);
        return calculateMod11(secondDigitSum);
    }

    private int calculateSum(String cpfPart) {
        int start = cpfPart.length() - 1;
        int factor = CPF_DIGIT_LENGTH;
        int sum = 0;
        for (int i = start; i >= 0; i--) {
            sum += (Integer.parseInt(Character.toString(nationalID.charAt(i))) * factor);
            factor++;
        }
        return sum;
    }

    private int calculateMod11(int sum) {
        int remainder = sum % CPF_MOD;
        if (remainder < 2) {
            return 0;
        } else {
            return CPF_MOD - remainder;
        }
    }

    @Override
    public String toString() {
        return nationalID;
    }

}
