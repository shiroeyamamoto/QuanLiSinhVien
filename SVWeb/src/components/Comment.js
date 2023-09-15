import React from 'react';

const Comment = ({ avatar, name, topComment, timeAgo, content, likes, reply }) => {
  return (
    <div className="d-flex flex-row p-3">
      <img src={avatar} width="40" height="40" className="rounded-circle mr-3" />
      <div className="w-100">
        <div className="d-flex justify-content-between align-items-center">
          <div className="d-flex flex-row align-items-center">
            <span className="mr-2">{name}</span>
            {topComment && <small className="c-badge">Top Comment</small>}
          </div>
          <small>{timeAgo}</small>
        </div>
        <p className="text-justify comment-text mb-0">{content}</p>
        <div className="d-flex flex-row user-feed">
          <span className="wish"><i className="fa fa-heartbeat mr-2"></i>{likes}</span>
          <span className="ml-3"><i className="fa fa-comments-o mr-2"></i>{reply}</span>
        </div>
      </div>
    </div>
  );
};

export default Comment;
