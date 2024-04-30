package org.example.component;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.a7.A7_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.List;
import java.util.function.Function;

public class TableComponent {



    public <T> void createTable(List<String> headers, List<T> data, Function<T, List<String>> rowMapper) {

      AsciiTable instance = new AsciiTable();
        instance.getContext().setGrid(A7_Grids.minusBarPlusEquals());


        instance.addRule();
        instance.addRow(headers);
        instance.addRule();

        data.forEach(item -> instance.addRow(rowMapper.apply(item)));
        instance.addRule();


        instance.setTextAlignment(TextAlignment.CENTER);

        System.out.println(instance.render());

    }

}


