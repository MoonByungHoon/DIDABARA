import {
  Divider,
  Icon,
  iconButtonClasses,
  List,
  ListItem,
  ListItemButton,
  ListItemIcon,
  ListItemText,
} from "@mui/material";
import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const list = [
  {
    primaryText: "홈",
    icon: "home",
    url: "/mypage/main",
  },
  {
    primaryText: "개인 정보",
    icon: "person",
    url: "/mypage/personal-info",
  },
  {
    primaryText: "내가 만든",
    icon: "description",
    url: "/mypage/unnamed01",
  },
  {
    primaryText: "내가 본",
    icon: "task",
    url: "/mypage/unnamed02",
  },
  {
    primaryText: "참여 목록",
    icon: "folder",
    url: "/mypage/unnamed03",
  },
  {
    primaryText: "즐겨찾기",
    icon: "star",
    url: "/mypage/starred",
  },
];

function MypageLists() {
  const navi = useNavigate();
  const [selectedIndex, setSelectedIndex] = useState(0);
  const handleListItemClick = (event, index) => {
    setSelectedIndex(index);
  };

  return (
    <List>
      {list.map((item, i) => (
        <ListItem
          key={i}
          selected={selectedIndex === i}
          button
          onClick={(event) => {
            handleListItemClick(event, i);
            navi(item.url);
          }}
        >
          <ListItemIcon>
            <Icon>{item.icon}</Icon>
          </ListItemIcon>
          <ListItemText
            primary={item.primaryText}
            primaryTypographyProps={{ noWrap: true }}
          />
        </ListItem>
      ))}
      <Divider />
    </List>
  );
}

export default MypageLists;
