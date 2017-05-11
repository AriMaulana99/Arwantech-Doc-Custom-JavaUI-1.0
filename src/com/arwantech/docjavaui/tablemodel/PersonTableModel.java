/*
 * Copyright (c) 2017 ARWANTECH CREATIVE TEAM
 *
 * Anda diperkenankan mengedit isi dari source code ini
 * asalkan tetap menyertakan copyright ini.
 *
 * File ini dibuat menggunakan :
 * Editor     : NetBeans IDE 8.0.2
 * NoteBook   : ASUS Notebook K42F
 * OS         : Windows 10 Pro 64bit
 * Compiler   : JDK 8 update 18
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 *      http://www.apache.org/licenses/LICENSE-2.0
 */
package com.arwantech.docjavaui.tablemodel;

import com.arwantech.docjavaui.domain.Person;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class PersonTableModel extends AbstractTableModel {

    private final List<Person> persons;

    public PersonTableModel(List<Person> listPerson) {
        this.persons = listPerson;
    }

    @Override
    public int getRowCount() {
        return persons.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = persons.get(rowIndex);
        switch (columnIndex) {
            case 0 : return person.getId();
            case 1 : return person.getName();
            case 2 : return person.getAge();
            case 3 : return person.getAddress();
            default: return "";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "ID";
            case 1 : return "NAME";
            case 2 : return "AGE";
            case 3 : return "ADDRESS";
            default : return "";
        }
    }
    
}
