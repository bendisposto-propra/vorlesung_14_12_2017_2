package de.hhu.stups.propra.orm;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlainORM {

	public static void main(String[] args) {
		SpringApplication.run(PlainORM.class, args);
	}

	@Bean
	public CommandLineRunner go(PostRepository repo) {
		return args -> {

			BlogEntry be2 = new BlogEntry();
			Thread.sleep(2200);
			BlogEntry be1 = new BlogEntry();
			Thread.sleep(1200);
			BlogEntry be3 = new BlogEntry();

			be1.setTitle("xx");
			be1.setText("1");
			be2.setTitle("xxx");
			be2.setText("3");
			be3.setTitle("xx");
			be3.setText("2");

			repo.save(be3);
			repo.save(be1);
			repo.save(be2);

			System.out.println("------------ xx by ID Desc");

			List<BlogEntry> list = repo.readStuffByTitleOrderByIdDesc("xx");
			for (BlogEntry blogEntry : list) {
				System.out.println(blogEntry);
			}

			System.out.println(repo.count());
			System.out.println(repo.countBlogPostsByTitle("xx"));

			System.out.println("------------ All by Date Desc");

			list = repo.findAllByOrderByDateDesc();
			for (BlogEntry blogEntry : list) {
				System.out.println(blogEntry);
			}

			System.out.println("------------ Trololo");
			list = repo.trololo("xx");
			for (BlogEntry blogEntry : list) {
				System.out.println(blogEntry);
			}


		};
	}

}
