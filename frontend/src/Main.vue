<template>
    <div style="text-align: -webkit-center;">
        <v-card style="width: 700px; height: 1000px; padding: 30px;">
            <v-card-title style="font-size:30px; font-weight:700; width: 100%;"><b>이현지님</b>
                <v-btn outlined rounded style="margin-left: 10px;"><b>전체계좌</b></v-btn>
                <v-avatar color="red" size="20"
                    style="font-size:10px; float: right; margin-right: 10px; margin-left: -10px; color: white; position: absolute; margin-left: 73.6%; margin-top: -13px; z-index: 99;">
                    N
                </v-avatar>
                <v-btn icon style="margin-left: 16%;">
                    <v-icon large>mdi-bell-outline</v-icon>
                </v-btn>
            </v-card-title>
            <v-card elevation="2" width="500" height="300" class="mx-auto" style="margin-top:50px; padding: 10px;"><br>
                <div style="text-align:left;">
                    <v-avatar>
                        <v-img max-height="30" max-width="30"
                            src="data:image/jpeg;base64,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">
                        </v-img>
                    </v-avatar>
                </div>
                <div style="font-size:20px; font-weight:700; text-align:left;">
                    <p>Knowhow 통장</p>
                </div>
                <div style="font-size:15px; font-weight:500; text-align:left; margin-top:-10px;">
                    <p>입출금 162-910305-85107</p>
                </div>
            </v-card>

            <div style="display:flex; margin-top:50px;" class="mx-auto">
                <v-card elevation="2" width="100" height="100">
                    <div style="position:absolute; top:50%; left:50%; transform: translate(-50%,-50%);">
                        <v-icon x-large color="teal" style="display:flex; align-items: center; justify-content: center">
                            mdi-account-circle</v-icon>
                        <p style="font-size:11px; font-weight:700;">전체계좌</p>
                    </div>
                </v-card>

                <v-card elevation="2" width="100" height="100" style="margin-left:20px">
                    <div style="position:absolute; top:50%; left:50%; transform: translate(-50%,-50%);">
                        <v-icon x-large color="purple">mdi-star</v-icon>
                        <p style="font-size:11px; font-weight:700;">영하나</p>
                    </div>
                </v-card>

                <v-card elevation="2" width="100" height="100" style="margin-left:20px">
                    <div style="position:absolute; top:50%; left:50%; transform: translate(-50%,-50%);">
                        <v-icon x-large color="purple">mdi-gift</v-icon>
                        <p style="font-size:11px; font-weight:700;">이벤트</p>
                    </div>
                </v-card>

            </div>

            <div style="display:flex; margin-top:50px; text-aligh:center">
                <v-card elevation="2" width="100" height="100">
                    <div style="position:absolute; top:50%; left:50%; transform: translate(-50%,-50%);">
                        <v-icon x-large color="teal">mdi-arrow-top-right</v-icon>
                        <p style="font-size:11px; font-weight:700;">주식추천</p>
                    </div>
                </v-card>

                <v-card elevation="2" width="100" height="100" style="margin-left:20px">
                    <div style="position:absolute; top:50%; left:50%; transform: translate(-50%,-50%);">
                        <v-icon x-large color="purple">mdi-movie</v-icon>
                        <p style="font-size:11px; font-weight:700;">생활/제휴</p>
                    </div>
                </v-card>

                <v-card elevation="2" width="100" height="100" style="margin-left:20px">
                    <div style="position:absolute; top:50%; left:50%; transform: translate(-50%,-50%);">
                        <v-icon x-large color="teal">mdi-information</v-icon>
                        <p style="font-size:11px; font-weight:700;">맞춤설정</p>
                    </div>
                </v-card>
            </div>

            <div style="width:350px; margin-top:50px;" class="mx-auto">
                <v-btn :to="'/sub'" block color="teal" rounded>
                    <div style="font-size:20px; font-weight:700; text-align:center; color:white">적금신청 하러가기</div>
                </v-btn>
            </div>
        </v-card>
    </div>
</template>
<script>
  export default {
    name: 'Main',
    data: () => ({ drawer: null }),
  }
</script>