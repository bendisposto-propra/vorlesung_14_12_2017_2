package de.hhu.stups.propra.orm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<BlogEntry, Long> {


	public List<BlogEntry> readStuffByTitleOrderByIdDesc(String t);

	public List<BlogEntry> findAllByOrderByDateDesc();

	public int countBlogPostsByTitle(String t);

	@Query(value = "select * from blog_entry as b where b.title = ?", nativeQuery = true)
	public List<BlogEntry> trololo(String title);

}
