import API from "../utility/api";

const addQuest = async (description, badgesReward, tokensReward, ownerUserId) => {
  try {
    const response = await API.post(`/quest/add`, {description, badgesReward, tokensReward , ownerUserId});
    return response.data;
  } catch (e) {
    console.log(e);
  }
};

export default addQuest;
