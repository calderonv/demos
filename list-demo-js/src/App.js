import React from 'react';
import logo from './logo.svg';
import './App.css';
import './components/List'
import List from "./components/List";
import ListAppHeader from "./components/ListAppHeader";
import FilterList from "./components/FilterList";

class App extends React.Component {

    state = {
        items: [],
        filteredItems: []
    };

    filterList = (filter) => {
        this.setState({
            filteredItems: [...this.state.items.filter(
                (item) => item.category.toLowerCase().includes(filter.toLowerCase())
            )]
    })
    };

    componentDidMount() {
        this.fetchData();
    }

    fetchData = () => {
        fetch("http://localhost:8080/demo/list")
            .then(res => res.json())
            .then(
                (result) => {
                    console.log(result.items);
                    this.setState({
                        items: result.items,
                        filteredItems: result.items
                    });
                }
            )
    };

    render() {
    return (
        <div className="App">
            <div className="container">
                <ListAppHeader />
                <FilterList filterList={this.filterList}/>
                <List items={this.state.filteredItems}/>
            </div>
        </div>
    );
    }
}

export default App;
