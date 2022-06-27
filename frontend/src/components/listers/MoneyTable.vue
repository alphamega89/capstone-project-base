<template>

    <v-data-table
            :headers="headers"
            :items="money"
            :items-per-page="5"
            class="elevation-1"
    ></v-data-table>

</template>

<script>

    export default {
        name: 'MoneyList',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { 
                    text: "amount", 
                    value: "amount" 
                },
                { 
                    text: "currency", 
                    value: "currency" 
                },
            ],
            money : [],
        }),
        async created() {
            if(!this.value) this.value = [];
        },
        methods: {
        }
    }
</script>

