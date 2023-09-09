import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import { useState } from 'react';

function EditScoreModal(props) {
  const [editedScore, setEditedScore] = useState("");
  const handleSave = () => {
    // Lấy giá trị của input sau khi bạn nhập điểm và bấm lưu
    const editedScoreValue = editedScore;
  
    // Gọi hàm callback để truyền giá trị ra bên ngoài
    props.onSave(editedScoreValue);
  
    // Đóng modal
    props.onClose();
  };
  return (
    <Modal show={props.show} onHide={props.onClose}>
      <Modal.Header closeButton>
        <Modal.Title>Sửa điểm</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        {/* Thêm input để nhập điểm muốn sửa */}
        <input
          type="number"
          placeholder="Nhập điểm muốn sửa"
          className="form-control"
          onChange={(e) => setEditedScore(e.target.value)}
        />
      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={props.onClose}>
          Close
        </Button>
        <Button variant="primary" onClick={handleSave}>
          Lưu
        </Button>
      </Modal.Footer>
    </Modal>
  );
}
export default EditScoreModal;