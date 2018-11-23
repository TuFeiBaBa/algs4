package edu.princeton.cs.algs4.leetcode.exercise;

import edu.princeton.cs.algs4.leetcode.Stack;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * @author TuFei
 * @date 18-11-23.
 */
class SimplifyPath {
    public String simplifyPath(String path) {
        Stack stack = new Stack();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (temp.length() == 0) {
                temp.append(c);
                continue;
            }
            if (c != '/') {
                temp.append(c);
            } else {
                switch (temp.toString()) {
                    case "/.":
                    case "/":
                        break;
                    case "/..":
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                        break;
                    default:
                        stack.push(temp.toString());
                        break;
                }
                temp = new StringBuilder("/");
            }
        }

        String s = temp.toString();
        if ("/..".equals(s) && !stack.isEmpty()) {
            stack.pop();
        }
        if (s.length() != 0 && !"/".equals(s) && !"/.".equals(s) && !"/..".equals(s)) {
            stack.push(s);
        }
        if (stack.isEmpty()) {
            return "/";
        } else {
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.insert(0, stack.pop());
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        SimplifyPath path = new SimplifyPath();
        println(path.simplifyPath("/../"));
        println(path.simplifyPath("/a/./b/../../c/"));
        println(path.simplifyPath("/home//foo/"));
        println(path.simplifyPath("/.../"));
        println(path.simplifyPath("/."));
        println(path.simplifyPath("/"));
        println(path.simplifyPath("/..."));
        println(path.simplifyPath("/.../.."));//"/"
        println(path.simplifyPath("/.../."));
    }
}
