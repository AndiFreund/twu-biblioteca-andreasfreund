/* task 1 */
SELECT member.name
FROM member, checkout_item, book
WHERE member.id = checkout_item.member_id
AND book.id = checkout_item.book_id
AND book.title = 'The Hobbit';

/* task 2 */
SELECT COUNT(*)
FROM
	(SELECT member.id
	FROM member
	EXCEPT
	SELECT member.id
	FROM member, checkout_item
	WHERE member.id = checkout_item.member_id);

/* task 3 */
SELECT book.title
FROM book
EXCEPT
SELECT book.title
FROM book, checkout_item
WHERE book.id = checkout_item.book_id
UNION
SELECT movie.title
FROM movie
EXCEPT
SELECT movie.title
FROM movie, checkout_item
WHERE movie.id = checkout_item.movie_id;

/* task 4 */
INSERT INTO book (title)
VALUES ("The Pragmatic Programmer");
INSERT INTO member (name)
VALUES ("Andreas Freund");
INSERT INTO checkout_item (member_id, book_id)
VALUES (43, 11);
SELECT member.name
FROM member, checkout_item, book
WHERE member.id = checkout_item.member_id
AND book.id = checkout_item.book_id
AND book.title = 'The Pragmatic Programmer’;

/* task 5 */
SELECT member.name
FROM member, checkout_item
WHERE member.id = checkout_item.member_id
GROUP BY member_id
HAVING COUNT(member_id) > 1;