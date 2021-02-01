package com.gourianova.service;


    public  class MathHelp {


        /*
         *
         * <p>Checks whether the String a valid Java number.</p>
         **/
        public static boolean isNumber(String s) {
            if (s.length() == 0) {
                return false;
            }

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if ((i != 0 && c == '-')
                        || (!Character.isDigit(c) && c != '-')
                        || (chars.length == 1 && c == '-')) {
                    return false;
                }
            }
            return true;

        }

        /*
         *
         * <p>Checks whether the divisor is a Divisor of the Java number.</p>
         **/


        static boolean isDivisor(long number, long divisor) {
            if (number % divisor == 0)
                return true;
            else
                return false;
        }

    }



