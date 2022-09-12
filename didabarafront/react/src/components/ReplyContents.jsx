import DeleteForeverOutlinedIcon from "@mui/icons-material/DeleteForeverOutlined";
import React, { useState } from "react";
import { useQuery } from "react-query";
import styled from "styled-components";
import { getItemReply } from "../config/APIs";

const ReplyBox = styled.div`
  padding: 0px 10px;
`;
const Wrapper = styled.div`
  border-bottom: 1px solid grey;
  padding: 0px 10px;
`;
const WriterAndDate = styled.div`
  display: grid;
  grid-template-columns: 60% 20% 20%;
`;
const TextBox = styled.div`
  width: 100%;
  overflow: auto;
  word-break: break-all;
`;

function ReplyContents({ item }) {
  const [replyList, setReplyList] = useState([]);
  //로직 작성 해야함
  // const deleteReply = () => {
  //   axios.delete(REQUEST_ADDRESS + `categoryItemReply/delete/${""}`);
  // };

  const { isLoading } = useQuery("reply", () => getItemReply(item), {
    refetchOnWindowFocus: false,
    retry: false,
    onSuccess: (data) => {
      console.log("이페이지의 리플라이:", data.data.resList);
      setReplyList(data.data.resList);
    },
  });

  return isLoading
    ? "Loading T.T..."
    : replyList?.map((reply) => {
        return (
          <ReplyBox>
            <Wrapper>
              <WriterAndDate>
                <h5 style={{ lineHeight: "50%" }}>{reply.writer}</h5>
                <p style={{ justifySelf: "end" }}>{reply.date}</p>
                <DeleteForeverOutlinedIcon
                  style={{
                    justifySelf: "end",
                    alignSelf: "center",
                    cursor: "pointer",
                  }}
                  // onClick={deleteReply}
                />
              </WriterAndDate>
              <TextBox>
                <p style={{ lineHeight: "100%" }}>{reply.content}</p>
              </TextBox>
            </Wrapper>
          </ReplyBox>
        );
      });
}

export default ReplyContents;
