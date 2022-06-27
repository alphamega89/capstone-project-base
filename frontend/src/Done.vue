<template>
  <v-app id="inspire">
    <v-card>
      <v-app-bar
        absolute
        color="white"
      >
        <v-btn :to="'/results'" icon>
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
        <v-card-title>가입이 성공적으로 완료되었어요!<br>2년 동안 잘 부탁해요!</v-card-title>
      </div>
      <div style="text-align: center; margin-bottom: 15px;">
        <v-btn :to="'/'" color="#178c72">
          <b style="color: white;">확인하러 가기</b>
        </v-btn>
      </div>
    </v-card>

    

    <v-main>
    </v-main>
  </v-app>
</template>

<script>
  export default {
    name:"Done",
    data: () => ({}),
  }
</script>