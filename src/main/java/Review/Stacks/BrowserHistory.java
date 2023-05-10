package Review.Stacks;
/*
You have a browser of one tab where you start on the homepage and you can visit another url, get back in
the history number of steps or move forward in the history number of steps.
Implement the BrowserHistory class:

BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
void visit(string url) Visits url from the current page. It clears up all the forward history.
string back(int steps) Move steps back in history. If you can only return x steps in the history
and steps > x, you will return only x steps. Return the current url after moving back in history at most
steps.

string forward(int steps) Move steps forward in history. If you can only forward x steps in the
history and steps > x, you will forward only x steps. Return the current url after forwarding in history
at most steps.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BrowserHistory {

// declare stacks and current
    Deque<String> history, forward;
    String currentPage;

// initialize stacks and current = homepage
    public BrowserHistory(String homepage) {
        history = new ArrayDeque<>();
        forward = new ArrayDeque<>();
        currentPage = homepage;
    }

    public void visit(String url) {
    // push 'current' in 'history' stack and mark 'url' as 'current'
        history.push(currentPage);
        currentPage = url;
        System.out.println(url + " is visited");
    // clear 'forward' stack
        forward = new ArrayDeque<>();
    }

    public String back(int steps) {
        int steps2 = steps; // used for printing action

    // push elements from 'current' to 'forward' stack and pop elements
    // from 'history' and assign to 'current' for specified # of steps
        while (steps > 0 && !history.isEmpty()) {

            forward.push(currentPage);
            currentPage = history.pop();
            steps--;
        }
        System.out.println("Back operation of " + steps2 + " brings " + currentPage);
        return currentPage;
    }

    public String forward(int steps) {
        int steps2 = steps; // used for printing action

        // reverse of back()
        while (steps > 0 && !forward.isEmpty()) {

            history.push(currentPage);
            currentPage = forward.pop();
            steps--;
        }
        System.out.println("Forward operation of " + steps2 + " brings " + currentPage);
        return currentPage;
    }

}
