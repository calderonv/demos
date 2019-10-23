import React from 'react'

class FilterList extends React.Component {
    state = {
        filter: ''
    };

    onChange = (e) => this.setState( {filter: e.target.value});

    onSubmit = (e) => {
        e.preventDefault();
        this.props.filterList(this.state.filter)
    };

    resetFilter = (e) => {
        e.preventDefault();
        this.setState({filter: ''});
        this.props.resetFilter()
    };

    render() {
        return (
            <div>
                <form style={{ display: 'flex' }} onSubmit={this.onSubmit}>
                    <input type="text" name="category" placeholder="filter category..." style={{flex: '10'}}
                           value={this.state.filter} onChange={this.onChange}/>
                    <input type="Submit" value="Filter List" className="filterButton" style={{flex: '1'}}/>
                    <input onClick={this.resetFilter} value="Reset Filter" className="filterButton" style={{flex: '1'}}/>
                </form>
            </div>
            )
    }
}

export default FilterList;