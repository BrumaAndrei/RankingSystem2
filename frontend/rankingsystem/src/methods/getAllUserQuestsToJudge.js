import API from "../utility/api";

const getAllUserQuestsToJudge = async (userId) => {
  try {
    const response = await API.get(`/userTriesQuest/judge/${userId}`);
    console.log("quests ", response.data);
    return response.data;
  } catch (e) {
    console.log(e);
  }
};

export default getAllUserQuestsToJudge;
