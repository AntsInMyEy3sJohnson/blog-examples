package com.nicokrieg.blog.examples.orthogonality;

import com.nicokrieg.blog.examples.orthogonality.inappropriateintimacy.Customer3;
import com.nicokrieg.blog.examples.orthogonality.lowcouplinghighcohesion.Customer2;
import com.nicokrieg.blog.examples.orthogonality.tightcoupling.Customer1;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List.of(
                new Customer1(101, "John"),
                new Customer1(102, "Jane"),
                new Customer2(201, "Dave"),
                new Customer2(202, "Donna"),
                new Customer3(301, "Luke"),
                new Customer3(302, "Linda")
        ).forEach(System.out::println);

    }

}
