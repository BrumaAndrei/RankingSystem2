import API from "../utility/api";

const startQuest = async (questId, userId) => {
  try {
    const response = await API.post(`/userTriesQuest/add`, {questId : questId, userId : userId});
    return response.data;
  } catch (e) {
    console.log(e);
  }
};

export default startQuest;
