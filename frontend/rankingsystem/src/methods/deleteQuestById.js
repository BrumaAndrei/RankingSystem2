import API from "../utility/api";

const deleteQuestById = async (questId) => {
  try {
    const response = await API.delete(`/quest/delete/${questId}`);
    console.log("quests ", response.data);
    return response.data;
  } catch (e) {
    console.log(e);
  }
};

export default deleteQuestById;
