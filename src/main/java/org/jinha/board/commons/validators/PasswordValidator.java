package org.jinha.board.commons.validators;

public interface PasswordValidator {
    /**
     * 비밀번호 복잡성 체크 - 알파벳 체크
     * @param password
     * @param caseIncentive
     *  false : 소문자 + 대문자가 반드시 포함되는 패턴
     *  true : 대소문자 상관없이 포함되는 패턴
     * @return
     */
    default boolean alphaCheck(String password, boolean caseIncentive){
        if(caseIncentive){//대소문자 구분 없이 체크

            return password.matches("[a-zA-Z]+");//+는 한자이상 포함, *는 없어도 상관 x
        }

        //대문자, 소문자 각각 체크
        return password.matches("[a-z]+") && password.matches("[A-Z]+");
    }

    /**
     * 비밀번호 복잡성 체크 - 숫자 체크
     * @param password
     * @return
     */
    default boolean numberCheck(String password){
        return password.matches("\\d+");
    }

    /**
     * 비밀번호 복잡성 체크 - 특수문자 체크
     * @param password
     * @return
     */
    default boolean specialCharsCheck(String password){
       return password.matches("[`~!#$%^&*()-_+=]+");
    }
}
