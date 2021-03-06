/*
 * Copyright (c) 2013-2016 Chris Newland.
 * Licensed under https://github.com/AdoptOpenJDK/jitwatch/blob/master/LICENSE-BSD
 * Instructions: https://github.com/AdoptOpenJDK/jitwatch/wiki
 */
package org.adoptopenjdk.jitwatch.ui;

import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public final class TableUtil
{
	private TableUtil()
	{
	}

	public static TableView<CompilationTableRow> buildTableMemberAttributes(ObservableList<CompilationTableRow> rows)
	{
		TableView<CompilationTableRow> tv = new TableView<>();

		TableColumn<CompilationTableRow, String> columnQueued = new TableColumn<CompilationTableRow, String>("Queued");
		columnQueued.setCellValueFactory(new PropertyValueFactory<CompilationTableRow, String>("queuedStamp"));
		columnQueued.prefWidthProperty().bind(tv.widthProperty().multiply(0.2));

		TableColumn<CompilationTableRow, String> columnCompiled = new TableColumn<CompilationTableRow, String>("Compiled");
		columnCompiled.setCellValueFactory(new PropertyValueFactory<CompilationTableRow, String>("compiledStamp"));
		columnCompiled.prefWidthProperty().bind(tv.widthProperty().multiply(0.2));

		TableColumn<CompilationTableRow, String> columnSize = new TableColumn<CompilationTableRow, String>("Native Size");
		columnSize.setCellValueFactory(new PropertyValueFactory<CompilationTableRow, String>("native"));
		columnSize.prefWidthProperty().bind(tv.widthProperty().multiply(0.2));

		TableColumn<CompilationTableRow, String> columnCompiler = new TableColumn<CompilationTableRow, String>("Compiler");
		columnCompiler.setCellValueFactory(new PropertyValueFactory<CompilationTableRow, String>("compiler"));
		columnCompiler.prefWidthProperty().bind(tv.widthProperty().multiply(0.2));

		TableColumn<CompilationTableRow, String> columnLevel = new TableColumn<CompilationTableRow, String>("Level");
		columnLevel.setCellValueFactory(new PropertyValueFactory<CompilationTableRow, String>("level"));
		columnLevel.prefWidthProperty().bind(tv.widthProperty().multiply(0.2));
		
		tv.getColumns().add(columnQueued);
		tv.getColumns().add(columnCompiled);
		tv.getColumns().add(columnSize);
		tv.getColumns().add(columnCompiler);
		tv.getColumns().add(columnLevel);

		tv.setItems(rows);

		return tv;
	}

	public static TableView<StatsTableRow> buildTableStats(ObservableList<StatsTableRow> rows)
	{
		TableView<StatsTableRow> tv = new TableView<>();

		TableColumn<StatsTableRow, String> colName = new TableColumn<StatsTableRow, String>("Name");
		colName.setCellValueFactory(new PropertyValueFactory<StatsTableRow, String>("name"));
		colName.prefWidthProperty().bind(tv.widthProperty().multiply(0.33));

		TableColumn<StatsTableRow, Long> colValue = new TableColumn<StatsTableRow, Long>("Value");
		colValue.setCellValueFactory(new PropertyValueFactory<StatsTableRow, Long>("value"));
		colValue.prefWidthProperty().bind(tv.widthProperty().multiply(0.66));

		tv.getColumns().add(colName);
		tv.getColumns().add(colValue);

		tv.setItems(rows);

		return tv;
	}
}