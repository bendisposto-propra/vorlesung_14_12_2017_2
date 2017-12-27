package de.hhu.stups.propra.orm.uni;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.hhu.stups.propra.orm.uni.model.Buch;
import de.hhu.stups.propra.orm.uni.model.BuchExemplar;
import de.hhu.stups.propra.orm.uni.model.Fakultaet;
import de.hhu.stups.propra.orm.uni.model.Lehrstuhl;
import de.hhu.stups.propra.orm.uni.model.Professor;
import de.hhu.stups.propra.orm.uni.model.Student;
import de.hhu.stups.propra.orm.uni.repositories.BuchRepository;
import de.hhu.stups.propra.orm.uni.repositories.ProfessorRepository;

@SpringBootApplication
public class UniRunner {

	public static void main(String[] args) {
		SpringApplication.run(UniRunner.class, args);
	}

	@Bean
	public CommandLineRunner go(ProfessorRepository profs, BuchRepository books) {
		return args -> {
			System.out.println("START");
			Lehrstuhl dbs = new Lehrstuhl();
			dbs.setName("Datenbanken");
			dbs.setFakultaet(Fakultaet.MATH_NAT);

			Lehrstuhl theo = new Lehrstuhl();
			theo.setName("Katholische Theologie");
			theo.setFakultaet(Fakultaet.PHIL_FAK);

			Professor sconrad = new Professor();
			sconrad.setName("Stefan Conrad");
			sconrad.setLehrstuhl(dbs);
			Professor aconrad = new Professor();
			aconrad.setName("Anne Conrad");
			aconrad.setLehrstuhl(theo);

			Student s1 = new Student();
			Student s2 = new Student();
			Student s3 = new Student();
			Student s4 = new Student();

			aconrad.setMeh(Arrays.asList(s1, s3, s4));
			sconrad.setMeh(Arrays.asList(s2, s4));

			profs.save(Arrays.asList(aconrad, sconrad));

			List<Professor> conrads = 
			   profs.findProfessorByNameLike("%Conrad%");

			System.out.println("Conrads");
			for (Professor c : conrads) {
				System.out.println(c);
			}
			
			System.out.println("1:n");

			Buch b = new Buch();
			b.setTitel("Harry Potter und der Fluch von Spring");
			b.setAutor("S.Q.L. Rowling");

			BuchExemplar e1 = new BuchExemplar();
			e1.setStammdaten(b);
			e1.setSignatur("0815");

			BuchExemplar e2 = new BuchExemplar();
			e2.setStammdaten(b);
			e2.setSignatur("4711");

			b.setExemplare(Arrays.asList(e1, e2));
			books.save(b);

			Buch buch = books.findOne(1L);
			System.out.println(buch);

			System.out.println("done");

		};
	}

}
