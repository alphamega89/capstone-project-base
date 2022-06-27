<template>
  <v-app id="inspire">
    <v-card>
      <v-app-bar
        absolute
        color="white"
      >
        <v-btn icon>
          <v-icon large>mdi-chevron-left</v-icon>
        </v-btn>

        <v-toolbar-title>적금/청약</v-toolbar-title>

        <v-spacer></v-spacer>
        
        <v-btn icon large>
          <v-icon>mdi-home-outline</v-icon>
        </v-btn>

        <v-app-bar-nav-icon large></v-app-bar-nav-icon>

      </v-app-bar>
      <div style="margin:30px; margin-top: 50px;">
        <v-card-title>____님<br>하나청년적금은요?
          <v-btn icon style="position: absolute; margin-left: 66%;"><v-icon>mdi-share-variant</v-icon></v-btn>
          <v-btn icon style="position: absolute; margin-left: 75%;"><v-icon>mdi-heart-outline</v-icon></v-btn>
        </v-card-title>
      </div>
      <div style="display:flex; margin-left:60px">
        <div style="text-align:center">
          <v-icon x-large color="teal">mdi-copyright</v-icon><br>
          <span style="font-size:15px; font-weight:500;">가입기간</span><br>
          <span style="font-size:13px; font-weight:700;">1만원 이상</span><br>
          <span style="font-size:13px; font-weight:700;">50만원 이하</span>
        </div>
        <div style="margin-left:50px; text-align:center">
          <v-icon x-large color="teal">mdi-calendar</v-icon><br>
          <span style="font-size:15px; font-weight:500;">가입금액</span><br>
          <span style="font-size:13px; font-weight:700;">2년</span>
        </div>
        <div style="margin-left:50px; text-align:center">
          <v-icon x-large color="teal">mdi-wallet-travel</v-icon><br>
          <span style="font-size:15px; font-weight:500;">최대금리</span><br>
          <span style="font-size:13px; font-weight:700;">연 5%</span>
        </div>

        <br>
      </div>
      <div style="margin: 50px;">
        <b>단, 소득이<br>2021년 총급여 3600만원 또는 종합소득금이<br>2600만원 이하만 가능해요!<br>사전 신청 후 소득 확인해볼까요?</b>
      </div>
      <div style="text-align: center; margin-bottom: 15px;">
        <v-btn color="#178c72" :to="'/result'"><b style="color: white;">소득 확인해보러가기</b></v-btn>
      </div>
    </v-card>

    

    <v-main>
    </v-main>
  </v-app>
</template>

<script>
  export default {
    name:"Sub",
    data: () => ({}),
  }
</script>