<template>

    <v-data-table
            :headers="headers"
            :items="photo"
            :items-per-page="5"
            class="elevation-1"
    ></v-data-table>

</template>

<script>

    export default {
        name: 'PhotoList',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { 
                    text: "imgName", 
                    value: "imgName" 
                },
                { 
                    text: "imgFile", 
                    value: "imgFile" 
                },
            ],
            photo : [],
        }),
        async created() {
            if(!this.value) this.value = [];
        },
        methods: {
        }
    }
</script>

