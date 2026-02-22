import React, { useState } from 'react';
import './App.css';

const StudentList = () => {
  // ข้อมูลเริ่มต้น (ตัวอย่าง)
  const [students, setStudents] = useState([
  ]);

  // State สำหรับรับค่าจากฟอร์ม
  const [studentId, setStudentId] = useState("");
  const [name, setName] = useState("");
  const [score, setScore] = useState("");

  // ฟังก์ชันเพิ่มข้อมูล
  const handleAddStudent = (e) => {
    e.preventDefault();

    // ตรวจสอบว่ากรอกครบทุกช่องหรือไม่
    if (!studentId || !name || !score) {
      alert("กรุณากรอกข้อมูลให้ครบทุกช่อง");
      return;
    }

    const newStudent = {
      id: Date.now(),
      studentId: studentId,
      name: name,
      score: score,
    };

    setStudents([...students, newStudent]);

    // ล้างค่าในฟอร์ม
    setStudentId("");
    setName("");
    setScore("");
  };

  // ฟังก์ชันลบข้อมูล
  const handleDeleteStudent = (id) => {
    const newList = students.filter((student) => student.id !== id);
    setStudents(newList);
  };

  return (
    <div className="container">
      <h2 className="title">Student List</h2>

      {/* ฟอร์มเพิ่มข้อมูล */}
      <form onSubmit={handleAddStudent} className="add-form">
        <div className="input-group">
          <input
            type="text"
            className="input-field"
            placeholder="รหัสนักศึกษา"
            value={studentId}
            onChange={(e) => setStudentId(e.target.value)}
          />
          <input
            type="text"
            className="input-field name-input"
            placeholder="ชื่อ-นามสกุล"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>
        
        <div className="input-group">
          <input
            type="number"
            className="input-field"
            placeholder="คะแนน"
            value={score}
            onChange={(e) => setScore(e.target.value)}
          />
          <button type="submit" className="btn btn-add">
            เพิ่ม
          </button>
        </div>
      </form>

      <hr style={{ border: '0', borderTop: '1px solid #eee' }} />

      {/* ตารางแสดงผล */}
      {students.length === 0 ? (
        <p className="empty-message">-- ยังไม่มีข้อมูลนักศึกษา --</p>
      ) : (
        <table className="student-table">
          <thead>
            <tr>
              <th style={{ width: '20%' }}>รหัส</th>
              <th style={{ width: '35%' }}>ชื่อ-นามสกุล</th>
              <th style={{ width: '15%', textAlign: 'center' }}>คะแนน</th>
              <th style={{ width: '15%', textAlign: 'center' }}>จัดการ</th>
            </tr>
          </thead>
          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.studentId}</td>
                <td>{student.name}</td>
                <td style={{ textAlign: "center" }}>{student.score}</td>
                <td style={{ textAlign: "center" }}>
                  <button
                    className="btn btn-delete"
                    onClick={() => handleDeleteStudent(student.id)}
                  >
                    ลบ
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default StudentList;