import React from "react";

import './userCard.styles.css';

const UserCard = (props) => {
  const user = props.user;
  return (
    <>
      <div onClick={onclick} className="quest-card">
        <p>id : {user.id}</p>
        <p>Name : {user.firstName + ' ' + user.lastName}</p>
        <p>Badges : {user.badges}</p>
        <p>Tokens : {user.tokens}</p>
      </div>
    </>
  );
};

export default UserCard;
