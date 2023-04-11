import React from "react";

import './questCard.styles.css';

const QuestCard = (props) => {
  const quest = props.quest;
  const owner = props.owner;
  const onclick = props.onclick;
  const selected = props.selected;
  return (
    <>
      {selected ? <div onClick={onclick} className="quest-card-selected">
        <p>Quest id : {quest.questId}</p>
        <p>Description : {quest.description}</p>
        <p>Badges : {quest.badgesReward}</p>
        <p>Tokens : {quest.tokensReward}</p>
        {owner ? '' : <p>{quest.completed ? 'completed' : 'in progress'}</p>}
      </div> : 
      <div onClick={onclick} className="quest-card">
        <p>Quest id : {quest.questId}</p>
        <p>Description : {quest.description}</p>
        <p>Badges : {quest.badgesReward}</p>
        <p>Tokens : {quest.tokensReward}</p>
        {owner ? '' : <p>{quest.completed ? 'completed' : 'in progress'}</p>}
      </div>
      }
    </>
  );
};

export default QuestCard;
