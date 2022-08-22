import React, { useState } from "react";
import { Grid, Button } from "@mui/material";
import PictureAsPdfSharpIcon from "@mui/icons-material/PictureAsPdfSharp";
import LoginSharpIcon from "@mui/icons-material/LoginSharp";
import LogoutSharpIcon from "@mui/icons-material/LogoutSharp";
import { useNavigate } from "react-router-dom";

function NavigationBar() {
  const navi = useNavigate();
  const [userLogin, setUserLogin] = useState(false);
  return (
    <Grid
      container
      justifyContent="center"
      alignItems="center"
      style={{
        position: "sticky",
        top: 0,
        backgroundColor: "orange",
        padding: "10px",
        zIndex: 3,
      }}
    >
      <Grid
        container
        item
        xs={6}
        md={5}
        spacing={2}
        alignItems="center"
        justifyContent="start"
      >
        <Grid item display="flex" alignItems="center" ml={2}>
          <PictureAsPdfSharpIcon fontSize="large" />
        </Grid>
        <Grid item>
          <Button variant="black">My Page</Button>
        </Grid>
      </Grid>

      <Grid container item xs={6} md={5} justifyContent="end">
        {userLogin ? (
          <>
            <Grid item display="flex" alignItems="center">
              <LogoutSharpIcon />
            </Grid>
            <Grid item mr={3}>
              <Button
                variant="black"
                onClick={() => {
                  // navi("/join");
                }}
              >
                Logout
              </Button>
            </Grid>
          </>
        ) : (
          <>
            <Grid item display="flex" alignItems="center">
              <LoginSharpIcon />
            </Grid>
            <Grid item mr={3}>
              <Button
                variant="black"
                onClick={() => {
                  navi("/login");
                }}
              >
                Login
              </Button>
            </Grid>
          </>
        )}

        <Grid item mr={2}>
          <Button
            variant="black"
            onClick={() => {
              navi("/join");
            }}
          >
            Join
          </Button>
        </Grid>
      </Grid>
    </Grid>
  );
}

export default NavigationBar;
