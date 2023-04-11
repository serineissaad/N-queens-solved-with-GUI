package com.example.hello;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.example.hello.BFS.*;



public class SessionController {
    @FXML
    private BorderPane mainWordPane;

    @FXML
    private TextField queens;
    @FXML
    private SplitPane splitWordList;
    @FXML
    private Label g1;
    @FXML
    private Label e1;
    @FXML
    private Label t1;
    @FXML
    private Label s1;
    @FXML
    private Label s3;
    @FXML
    private Label g3;
    @FXML
    private Label e3;
    @FXML
    private Label t3;
    @FXML
    private Label s2;
    @FXML
    private Label g2;
    @FXML
    private Label e2;
    @FXML
    private Label t2;
    @FXML
    private Label llll1;
    @FXML
    private Label llll2;
    @FXML
    private Label llll3;
    @FXML
    private Label llll4;
    @FXML
    private Label llll5;
    ObservableList<String> list = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> methodes;
    GUIPuzzle guiPuzzle = new GUIPuzzle();
    int ntot;
    public int getNum(TextField tf) {return Integer.parseInt(tf.getText());}

    @FXML
    void runDFS() {
        int queensNum = getNum(queens);
        check();
        if (queensNum <= 3||queensNum>50 ) return;
     //   BFS.setFeuilles();
     //   BFS.setNoeudsExplores();
     //   BFS.setNoeudsGeneres();
        int[] res = new int[getNum(queens)];
        Solution solution = new Solution(res);



        long start = System.currentTimeMillis();
        DFS.solve(res, 0, solution);
        long end = System.currentTimeMillis();
        if (solution.getDone() == 1) {
            showResult(solution.sol);
        }
        t2.setText( end - start + " ms");
        g2.setText(String.valueOf(solution.getDev()));
        e2.setText(String.valueOf(solution.getNb()));
        s2.setText(Arrays.toString(solution.sol));

    }
    @FXML
    void runBFS() {
        int queensNum = getNum(queens);
        check();
        if (queensNum <= 3||queensNum>50 ) return;
        BFS.setFeuilles();
        BFS.setNoeudsExplores();
        BFS.setNoeudsGeneres();
     //   int[] res = new int[getNum(queens)];
     //   Solution solution = new Solution(res);
        long start = System.currentTimeMillis();
     //   BFS.solve(getNum(queens));
       int[] res = BFS.solve(getNum(queens));
        long end = System.currentTimeMillis();
      /*  if (solution.getDone() == 1) {
            showResult(solution.sol);
        }*/
        showResult(res);
        t1.setText( end - start + " ms");
        g1.setText(String.valueOf(noeudsGeneres));
        e1.setText(String.valueOf(noeudsExplores));
        s1.setText(Arrays.toString(res));

    }
    @FXML
    void runAstar1() {
        int queensNum = getNum(queens);
        check();
        if (queensNum <= 3||queensNum>50 ) return;
        long start = System.currentTimeMillis();
        Astar1 solver = new Astar1(getNum(queens));
        int[] res = solver.solve();
        long end = System.currentTimeMillis();
        showResult(res);
        System.out.println("solu : " + Arrays.toString(res));
        System.out.println("gene " + Astar1.getGeneratedNodes());
        System.out.println("expl : " + Astar1.getExploredNodes());
        t3.setText( end - start + " ms");
        g3.setText(String.valueOf(Astar1.getGeneratedNodes()));
        e3.setText(String.valueOf(Astar1.getExploredNodes()));
        s3.setText(Arrays.toString(res));
    }

    @FXML
    void runAstar2() {
        int queensNum = getNum(queens);
        check();
        if (queensNum <= 3||queensNum>50 ) return;
        long start = System.currentTimeMillis();
        Astar2 solver = new Astar2(getNum(queens));
        int[] res = solver.solve();
        long end = System.currentTimeMillis();
        showResult(res);
        System.out.println("solu : " + Arrays.toString(res));
        System.out.println("gene " + Astar2.getGeneratedNodes());
        System.out.println("expl : " + Astar2.getExploredNodes());
        llll5.setText( end - start + " ms");
        llll1.setText(String.valueOf(ntot));
        llll2.setText(String.valueOf(Astar2.getGeneratedNodes()));
        llll3.setText(String.valueOf(Astar2.getExploredNodes()));
        llll4.setText(String.valueOf(Astar2.getLeaves()));
        /*lll2.setText(String.valueOf(Astar1.getGeneratedNodes()));
        lll3.setText(String.valueOf(Astar1.getExploredNodes()));
        lll4.setText(String.valueOf(Astar1.getLeaves()));
        lll2.setText(String.valueOf(Astar1.getGeneratedNodes()));
        lll3.setText(String.valueOf(Astar1.getExploredNodes()));
        lll4.setText(String.valueOf(Astar1.getLeaves()));*/
    }
    private void showResult(int[] res) {
        guiPuzzle.drawQueens(res);

    }
    @FXML
    private void reset() {
        int n=getNum(queens);
        check();
        if (n <= 3||n>50 ) return;
        //clear();


        int [] tab = new int[n];
        for (int i = 0; i < n; i++) {
        tab[i]=0;
        }
        guiPuzzle.drawQueens(tab);
        BFS.setFeuilles();
        BFS.setNoeudsExplores();
        BFS.setNoeudsGeneres();
        Astar1.setFeuilles();
        Astar1.setNoeudsExplores();
        Astar1.setNoeudsGeneres();
        Astar2.setFeuilles();
        Astar2.setNoeudsExplores();
        Astar2.setNoeudsGeneres();
        g1.setText(String.valueOf(noeudsGeneres));
        e1.setText(String.valueOf(noeudsExplores));
        s1.setText("Pas de solution");
        t1.setText("null");
        s3.setText("Pas de solution");
        t1.setText("null");
        llll5.setText("0");
        llll1.setText(String.valueOf(0));


    }
    private void check (){
        int queensNum = getNum(queens);
        if (queensNum <= 3) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please choose a number greater than 3 for the number of queens.");
            alert.showAndWait();
        }
        else if (queensNum > 50) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please choose a number less than or equal to 50 for the number of queens.");
            alert.showAndWait();
        }
    }

    private void loadData(){
        methodes.setValue("Methode");
        methodes.setStyle("-fx-font-weight: bold; -fx-background-color: #ADD8E6;");
        methodes.setMaxWidth(130);
        // list.removeAll(list);
        String a="Bfs";
        String b="Dfs";
        String c="Astar1";
        String d="Astar2";
        list.addAll(a,b,c,d);
        methodes.getItems().addAll(list);
    }
    @FXML
    private void display(){
        String methode=methodes.getValue();
        if (Objects.equals(methode, "Methode")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please choose a methode.");
            alert.showAndWait();
        }
        if (Objects.equals(methode, "Bfs")) {runBFS();}
        if (Objects.equals(methode, "Dfs")) {runDFS();}
        if (Objects.equals(methode, "Astar1")) {runAstar1();}
        if (Objects.equals(methode, "Astar2")) {runAstar2();}

    }

    String regex = "[0-9]*";

    // Create a TextFormatter that uses the regular expression to restrict input
    TextFormatter<String> formatter = new TextFormatter<>(change -> {
        String newText = change.getControlNewText();
        if (newText.matches(regex)) {
            return change;
        } else {
            return null;
        }
    });


    @FXML
    private Accordion myAccordion;
    @FXML
    void initialize() {
        queens.setTextFormatter(formatter);
        assert mainWordPane != null : "fx:id=\"mainWordPane\" was not injected: check your FXML file 'session.fxml'.";
        assert queens != null : "fx:id=\"queens\" was not injected: check your FXML file 'session.fxml'.";
        assert splitWordList != null : "fx:id=\"splitWordList\" was not injected: check your FXML file 'session.fxml'.";
        mainWordPane.setCenter(guiPuzzle);
        mainWordPane.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, new Insets(0, 0, 0, 0))));
        loadData();
      //  splitWordList.setResizableWithParent(myAccordion, Boolean.TRUE);
    }
}
