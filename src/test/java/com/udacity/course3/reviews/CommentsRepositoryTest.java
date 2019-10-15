package com.udacity.course3.reviews;

import com.udacity.course3.reviews.domain.comments.Comments;
import com.udacity.course3.reviews.domain.comments.CommentsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import javax.persistence.EntityManager;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentsRepositoryTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired private TestEntityManager testEntityManager;
    @Autowired private CommentsRepository commentRepository;

    @Test
    public void injectedComponentsAreNotNull(){
        assertNotNull(entityManager);
        assertNotNull(testEntityManager);
        assertNotNull(commentRepository);
    }

    @Test
    public void testSaveComments(){
        Comments comment = new Comments("nice", "perfect");
        commentRepository.save(comment);

        Optional<Comments> optionalComment2 = commentRepository.findById(comment.getId());
        Comments comment2 = optionalComment2.get();
        System.out.println("comment2 "+comment2);
        assertNotNull(comment);
        assertEquals(comment2.getCommentType(), comment.getCommentType());
        assertEquals(comment2.getCommentDetail(), comment.getCommentDetail());
    }

    @Test
    public void testDeleteComments(){
        Comments comment = new Comments("nice", "perfect");
        commentRepository.save(comment);
        commentRepository.delete(comment);
    }

    @Test
    public void testFindAllComments() {
        Comments comment = new Comments("nice", "perfect");
        commentRepository.save(comment);
        assertNotNull(commentRepository.findAll());
    }

    @Test
    public void testCommentsUpdate() {
        Comments comment = new Comments("nice", "perfect");
        commentRepository.save(comment);

        Optional<Comments> optionalComment = commentRepository.findById(comment.getId());
        Comments comment2 = optionalComment.get();
        comment2.setCommentType("average");
        comment2.setCommentDetail("needs perfection");

        commentRepository.save(comment2);
    }
}