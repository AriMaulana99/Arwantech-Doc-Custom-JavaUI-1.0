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
package com.arwantech.docjavaui.repository;

import com.arwantech.docjavaui.domain.Person;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AriMaulana99
 */
public class PersonRepository {
    
    
    // METHOD UNTUK MENGAMBIL SEMUA DATA DI TABLE PERSON
    public List<Person> readAll() throws SQLException {
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(0, new Person(1, "Ariansyah Maulana", 24, "Purwakarta"));
        listPerson.add(1, new Person(2, "Muhamad Ridwan", 23, "Jakarta"));
        listPerson.add(2, new Person(3, "Dimas R Ismail", 22, "Purwakarta"));
        listPerson.add(3, new Person(4, "Dede Barkah Sugiharto", 23, "Bandung"));
        listPerson.add(4, new Person(5, "Lilis Yulia Citra", 24, "Jakarta"));
        listPerson.add(5, new Person(6, "Agnia Nursilmi", 24, "Purwakarta"));
        listPerson.add(6, new Person(7, "Refgiantana Drajat", 24, "Jakarta"));
        listPerson.add(7, new Person(8, "Muhamad ZeniTohir", 24, "Purwakarta"));
        listPerson.add(8, new Person(9, "Muhamad Retno", 24, "Jakarta"));
        listPerson.add(9, new Person(10, "Ari Rahadi", 24, "Bandung"));
        listPerson.add(10, new Person(11, "Raden Hari Darmawan", 24, "Purwakarta"));
        listPerson.add(11, new Person(12, "Ahmad Furoni", 24, "Jakarta"));
        listPerson.add(12, new Person(13, "Rangga Tri Mumahad", 24, "Bandung"));
        listPerson.add(13, new Person(14, "Rima Putri", 24, "Jakarta"));
        listPerson.add(14, new Person(15, "Meilati Rara Kardinata", 24, "Purwakarta"));
        listPerson.add(15, new Person(16, "Tina Mardiana", 24, "Jakarta"));
        listPerson.add(16, new Person(17, "Muhamad Rizky Noval", 24, "Bandung"));
        listPerson.add(17, new Person(18, "Muhamad Fawaz", 24, "Jakarta"));
        listPerson.add(18, new Person(19, "Syarif", 24, "Purwakarta"));
        listPerson.add(19, new Person(20, "Taufan Hidayatullah", 24, "Bandung"));
        listPerson.add(20, new Person(21, "Yesi Sopia", 24, "Purwakarta"));
        listPerson.add(21, new Person(22, "Zakiya Nurahmah", 24, "Subang"));
        listPerson.add(22, new Person(23, "Sarita Guntari", 24, "Purwakarta"));
        listPerson.add(23, new Person(24, "Riski Ferdiansyah", 24, "Karawang"));
        listPerson.add(24, new Person(25, "Nita Nurlita", 24, "Bandung"));
        listPerson.add(25, new Person(26, "Zian Haris", 24, "Subang"));
        listPerson.add(26, new Person(27, "Linda Sari", 24, "Bandung"));
        listPerson.add(27, new Person(28, "Ridwan Andriansyah", 24, "Purwakarta"));
        listPerson.add(28, new Person(29, "Ifan Dwi Cahyo", 24, "Bandung"));
        listPerson.add(29, new Person(30, "Egi Juniawan", 24, "Purwakarta"));
        listPerson.add(30, new Person(31, "Dini Safitri", 24, "Subang"));
        listPerson.add(31, new Person(32, "Candri Pangaribuan", 24, "Bandung"));
        listPerson.add(32, new Person(33, "Yayah Khosiah", 24, "Karawang"));
        listPerson.add(33, new Person(34, "Siti Nur Asyiah", 24, "Bandung"));
        listPerson.add(34, new Person(35, "Triska", 24, "Bandung"));
        listPerson.add(35, new Person(36, "Octavia", 24, "Jakarta"));
        listPerson.add(36, new Person(37, "Rini", 24, "Purwakarta"));
        listPerson.add(37, new Person(38, "Amin Sudrajat", 24, "Karawang"));
        listPerson.add(38, new Person(39, "Ujang Sopian", 24, "Bandung"));
        listPerson.add(39, new Person(40, "Adam Mustakin", 24, "Karawang"));
        listPerson.add(40, new Person(41, "Muthi Alhusni", 24, "Jakarta"));
        listPerson.add(41, new Person(42, "Reynaldi", 24, "Purwakarta"));
        listPerson.add(42, new Person(43, "Intan Parhanawati", 24, "Jakarta"));
        listPerson.add(43, new Person(44, "Santi Rahayu", 24, "Bandung"));
        listPerson.add(44, new Person(45, "Ifan", 24, "Bandung"));
        listPerson.add(45, new Person(46, "Rizal Zulfikar", 24, "Jakarta"));
        listPerson.add(46, new Person(47, "Adi", 24, "Bandung"));
        listPerson.add(47, new Person(48, "Adrian", 24, "Purwakarta"));
        listPerson.add(48, new Person(49, "Tresna", 24, "Bandung"));
        listPerson.add(49, new Person(50, "Chandra Pesona", 24, "Jakarta"));
        listPerson.add(50, new Person(51, "Ahmad Subagja", 24, "Karawang"));

        return listPerson;
    }
    
}
