import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { Container, Button, Form } from 'react-bootstrap';

const PostDetail = () => {
  const { postId } = useParams();
  const [post, setPost] = useState(null);
  const [comments, setComments] = useState([]);
  const [newComment, setNewComment] = useState('');

  useEffect(() => {
    if (!postId) {
      return;
    }

    // Lấy thông tin bài viết
    axios.get(`http://localhost:8080/QuanLySinhVien/api/baiviet/lbaiviet/${postId}`)
      .then(response => {
        setPost(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });

    // Lấy danh sách bình luận
    axios.get(`http://localhost:8080/QuanLySinhVien/api/baiviet/lbaiviet/${postId}/comments`)
      .then(response => {
        setComments(response.data);
      })
      .catch(error => {
        console.error('Error fetching comments:', error);
      });
  }, [postId]);

  const handleCommentChange = (event) => {
    setNewComment(event.target.value);
  };

  const handleSubmitComment = () => {
    axios.post(`http://localhost:8080/QuanLySinhVien/api/baiviet/lbaiviet/${postId}/comments`, {
      content: newComment,
    })
      .then(response => {
        setComments([...comments, response.data]);
        setNewComment('');
      })
      .catch(error => {
        console.error('Error posting comment:', error);
      });
  };

  if (!post) {
    return <div>Loading...</div>;
  }

  return (
    <Container fluid className="h-100">
      <div className="d-flex flex-column justify-content-center align-items-center h-100">
        <div className="text-center">
          <h1>{post.titleBaiViet}</h1>
          <h3>{post.noiDungBaiViet}</h3>
          <p>Author: {post.accountAuthorName}</p>
        </div>
        <div className="w-100 mt-4">
          <h2 className="text-center">Comments</h2>
          <div className="overflow-auto" style={{ maxHeight: '60vh' }}>
            {post.commentBaiViet.map((comment, index) => (
              <div key={index} className="p-3 border rounded mb-2">
                <div className="d-flex justify-content-between">
                  <div className="d-flex align-items-center">
                    <img src={comment.imageAccountComment} width="40" height="40" className="rounded-circle mr-3" />
                    <div className="ml-2">
                      <h5>{comment.accountCommentName}</h5>
                    </div>
                  </div>


                </div>
                <p>{comment}</p>
              </div>
            ))}


          </div>
          <Form className="mt-3">
            <Form.Group controlId="newComment">
              <Form.Control
                as="textarea"
                rows={3}
                value={newComment}
                onChange={handleCommentChange}
                placeholder="Enter your comment..."
              />
            </Form.Group>
            <Button onClick={handleSubmitComment} variant="primary" type="button">
              Submit Comment
            </Button>
          </Form>
        </div>
      </div>
    </Container>
  );
};

export default PostDetail;
