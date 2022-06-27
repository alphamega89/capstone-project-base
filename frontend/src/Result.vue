<template>
  <v-app id="inspire">
    <v-card>
      <v-app-bar
        absolute
        color="white"
      >
        <v-btn :to="'/subs'" icon>
          <v-icon large>mdi-chevron-left</v-icon>
        </v-btn>

        <v-toolbar-title>적금/청약</v-toolbar-title>

        <v-spacer></v-spacer>
        
        <v-btn :to="'/main'" icon large>
          <v-icon>mdi-home-outline</v-icon>
        </v-btn>

        <v-app-bar-nav-icon large></v-app-bar-nav-icon>

      </v-app-bar>
      <div style="margin:30px; margin-top: 70px;">
        <v-card-title>____님은<br>작년 소득금액이 ____ 입니다.</v-card-title>
      </div>
      <div style="margin: 50px; ">
        <b>청년희망적금에 가입할 수 있어요!<br>가입하러 가볼까요?</b>
      </div>
      <div style="text-align: center; margin-bottom: 15px;">
        <v-btn :to="'/done'" color="#178c72">
          <b style="color: white;">청년희망적금 가입하기</b>
        </v-btn>
      </div>
    </v-card>

    

    <v-main>
    </v-main>
  </v-app>
</template>

<script>
  export default {
    name:"Result",
    data: () => ({}),
  }
</script>