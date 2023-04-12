import API from "../utility/api";

const updateQuest = async (questId, userId, completed) => {
  try {
    const response = await API.put(`/userTriesQuest/update`, {
      questId, userId, completed
    });
    console.log("quests ", response.data);
    return response.data;
  } catch (e) {
    console.log(e);
  }
};

export default updateQuest;
