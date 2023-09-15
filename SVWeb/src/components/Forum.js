import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import { Container, Button, ListGroup } from 'react-bootstrap';

const Forum = () => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/QuanLySinhVien/api/baiviet/lbaiviet')
      .then(response => {
        setPosts(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <Container>
      <h1>Forum</h1>
      <Button variant="primary" onClick={() => handleCreatePost()}>TẠO BÀI VIẾT</Button>
      <Button variant="secondary" onClick={() => handleMyPosts()}>BÀI VIẾT CÁ NHÂN</Button>
      <ListGroup>
        {posts.map(post => (
          <ListGroup.Item key={post.baiVietID}>
            <Link to={`/post/${post.baiVietID}`}>{post.titleBaiViet}</Link>
          </ListGroup.Item>
        ))}
      </ListGroup>
    </Container>
  );

  // Xử lý khi nhấp vào nút "TẠO BÀI VIẾT"
  const handleCreatePost = () => {
    // Thực hiện hành động khi nhấp vào nút "TẠO BÀI VIẾT" ở đây
    // Ví dụ: Điều hướng đến trang tạo bài viết
  };

  // Xử lý khi nhấp vào nút "BÀI VIẾT CÁ NHÂN"
  const handleMyPosts = () => {
    // Thực hiện hành động khi nhấp vào nút "BÀI VIẾT CÁ NHÂN" ở đây
    // Ví dụ: Điều hướng đến trang bài viết cá nhân
  };
};

export default Forum;
