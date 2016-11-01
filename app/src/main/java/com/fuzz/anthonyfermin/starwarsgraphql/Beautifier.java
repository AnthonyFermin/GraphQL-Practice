package com.fuzz.anthonyfermin.starwarsgraphql;

/**
 * Created by afermin on 10/31/16.
 */

public class Beautifier {

    public static String beautify(String json) {
        StringBuilder beautifiedJson = new StringBuilder();

        int indentCount = 0;
        boolean withinQuotes = false;
        for (int i = 0; i < json.length(); i++) {
            char current = json.charAt(i);
            if (current == '"') {
                withinQuotes = !withinQuotes;
            }
            if (withinQuotes && current == '\\') {
                i++;
                break;
            } else if (!withinQuotes && current == '}') {
                indentCount--;
                indent(beautifiedJson, indentCount);
            }
            beautifiedJson.append(current);
            if (!withinQuotes && current == '{') {
                indentCount++;
                indent(beautifiedJson, indentCount);
            } else if (!withinQuotes && current == ',') {
                beautifiedJson.append('\n');
            }
        }
        return beautifiedJson.toString();
    }

    private static void indent(StringBuilder beautifiedJson, int indentCount) {
        beautifiedJson.append("\n");
        for (int idx = 0; idx < indentCount; idx++) {
            beautifiedJson.append("    ");
        }
    }

}
